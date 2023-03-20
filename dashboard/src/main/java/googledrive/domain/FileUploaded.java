package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FileUploaded extends AbstractEvent {

    private Long id;
    private String name;
    private String type;
    private String size;
    private String uploadUser;
}
