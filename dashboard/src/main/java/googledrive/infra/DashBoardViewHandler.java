package googledrive.infra;

import googledrive.config.kafka.KafkaProcessor;
import googledrive.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashBoardViewHandler {

    @Autowired
    private DashBoardRepository dashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1(
        @Payload FileUploaded fileUploaded
    ) {
        try {
            if (!fileUploaded.validate()) return;

            // view 객체 생성
            DashBoard dashBoard = new DashBoard();
            // view 객체에 이벤트의 Value 를 set 함
            dashBoard.setFileId(fileUploaded.getId());
            dashBoard.setName(fileUploaded.getName());
            dashBoard.setFileSize(fileUploaded.getSize());
            dashBoard.setUploadUser(fileUploaded.getUploadUser());
            dashBoard.setIsUploaded(true);
            // view 레파지 토리에 save
            dashBoardRepository.save(dashBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileIndexed_then_UPDATE_1(
        @Payload FileIndexed fileIndexed
    ) {
        try {
            if (!fileIndexed.validate()) return;
            // view 객체 조회

            List<DashBoard> dashBoardList = dashBoardRepository.findByFileId(
                Long.valueOf(fileIndexed.getFileId())
            );
            for (DashBoard dashBoard : dashBoardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setIsIndexed(true);
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoProcessed_then_UPDATE_2(
        @Payload VideoProcessed videoProcessed
    ) {
        try {
            if (!videoProcessed.validate()) return;
            // view 객체 조회

            List<DashBoard> dashBoardList = dashBoardRepository.findByFileId(
                Long.valueOf(videoProcessed.getFileId())
            );
            for (DashBoard dashBoard : dashBoardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setVideoUrl(videoProcessed.getFileUrl());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
