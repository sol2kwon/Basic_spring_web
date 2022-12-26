package mini_project.mini_project_solyi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //jpa가 관리
public class Member {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY) //pk 자동 생성
    private Long id; //시스템이 구별하기 위한 id임

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
