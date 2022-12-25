package mini_project.mini_project_solyi.domain;

public class Member {
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
