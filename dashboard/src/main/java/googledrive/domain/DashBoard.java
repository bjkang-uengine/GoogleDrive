package googledrive.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DashBoard_table")
@Data
public class DashBoard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private Long fileId;
    private String fileSize;
    private String uploadUser;
    private String isUploaded;
    private String isIndexed;
    private String videoUrl;
}
