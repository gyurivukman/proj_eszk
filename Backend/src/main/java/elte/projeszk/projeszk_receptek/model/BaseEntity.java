package elte.projeszk.projeszk_receptek.model;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;
}
