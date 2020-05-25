package osp.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "MembersFunctions")
public class MembersFunctions {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idMember")
    private Member idMember;
    @ManyToOne
    @JoinColumn(name = "idFunction")
    private FunctionName idFunctionName;
    private LocalDateTime dateFunction;

    public MembersFunctions(){}

    public Member getIdMember() {
        return idMember;
    }

    public void setIdMember(Member idMember) {
        this.idMember = idMember;
    }

    public FunctionName getIdFunctionName() {
        return idFunctionName;
    }

    public void setIdFunctionName(FunctionName idFunctionName) {
        this.idFunctionName = idFunctionName;
    }

    public LocalDateTime getDateFunction() {
        return dateFunction;
    }

    public void setDateFunction(LocalDateTime dateFunction) {
        this.dateFunction = dateFunction;
    }
}
