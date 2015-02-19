package mousing;

public class GradStudent extends Student
{
   String previousDegree;

   public GradStudent()
   {
      address = "at school ";
      previousDegree = "BA";  
      
      super.enroll();
   }
   
   @Override
   public void enroll()
   {
      super.enroll();
   }
}
