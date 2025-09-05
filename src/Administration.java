import java.util.List;

public class Administration {
   private List<String> personal;
   private String name;
   private String  part;

   public Administration(List<String> personal, String name, String part) {
      this.personal = personal;
      this.name = name;
      this.part = part;
   }

   public List<String> getPersonal() {
      return personal;
   }

   public void setPersonal(List<String> personal) {
      this.personal = personal;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPart() {
      return part;
   }

   public void setPart(String part) {
      this.part = part;
   }
}
