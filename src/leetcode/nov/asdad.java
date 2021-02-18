package leetcode.nov;


public enum asdad {

    a("hh", "h"), b("cc", "c"), c("bb", "b");

    private String name;
    private String status;

    asdad(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public static void main(String[] args) {
        System.out.println(asdad.valueOf("a"));
    }

    @Override
    public String toString() {
        return "asdad{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
