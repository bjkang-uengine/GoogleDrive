package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FileIndexed extends AbstractEvent {

    private Long id;
    private List<String> keyword;
    private String fileId;
    private String fileType;
    private String uploadUser;
}
