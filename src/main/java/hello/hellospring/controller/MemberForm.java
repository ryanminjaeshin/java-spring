package hello.hellospring.controller;

public class MemberForm {
    // createMemberForm.html 내 <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
    // name="name"과 매칭.
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
