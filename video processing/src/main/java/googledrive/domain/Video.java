package googledrive.domain;

import googledrive.VideoProcessingApplication;
import googledrive.domain.VideoProcessed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileId;

    private String fileUrl;

    private String upLoadUser;

    @PostPersist
    public void onPostPersist() {
        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    public static void videoFileProcessStart(FileIndexed fileIndexed) {
        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileIndexed.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);


         });
        */

    }
}
