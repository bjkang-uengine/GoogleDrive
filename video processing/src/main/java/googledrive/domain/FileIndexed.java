package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileIndexed extends AbstractEvent {

    private Long id;
    private Object keyword;
    private String fileId;
    private String fileType;
    private String uploadUser;
}
