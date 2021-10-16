import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

interface googleClassroom{



    public void viewLectureMaterial();
    public void viewAssessments();
    public void viewComments();
  public void addComments();

  public void  logout();




}

class student  implements googleClassroom{


    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void viewLectureMaterial() {

    }

    @Override
    public void viewAssessments() {

    }

    @Override
    public void viewComments() {

    }

    @Override
    public void addComments() {

    }

    @Override
    public void logout(){

        System.out.println("Logging Out!!");


    }
}

class teacher implements googleClassroom{


    private HashMap<String  , ArrayList<String>> slide= new HashMap<>();
    private HashMap<String , String > video = new HashMap<>();

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, ArrayList<String>> getSlide() {
        return slide;
    }

    public HashMap<String, String> getVideo() {
        return video;
    }

    public void setSlide(HashMap<String, ArrayList<String>> slide) {
        this.slide = slide;
    }

    public void setVideo(HashMap<String, String> video) {
        this.video = video;
    }



    @Override
    public void viewLectureMaterial() {

    }

    @Override
    public void viewAssessments() {

    }

    @Override
    public void viewComments() {

    }

    @Override
    public void addComments() {

    }

    @Override
    public void logout() {

        System.out.println("Logging Out!!");
    }
}



public class MainClass  {

    public static void main(String  arg[]) throws Exception {
        int choice = 1;

        HashMap<String, teacher> t=  new HashMap<>();
        HashMap<String , student> s= new HashMap<>();


        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);



        while (true) {
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            int n=Integer.parseInt(br.readLine());
            if(n==1){

                System.out.println("Plesase Enter the ID of instructor: ");
                String id = br.readLine();
                teacher temp = t.get(id);

                System.out.println("Welcome : " +id);
                System.out.println("1. Add Lecture Slide\n" +
                        "2. Add Lecture Video");


                choice =Integer.parseInt(br.readLine());

                if(choice ==1){


                    System.out.println("Enter topic of slides:" );
                    String topic=br.readLine();
                    ArrayList<String > topicString  = new ArrayList<>();
                    System.out.println("Enter number of slides:");
                    int num= Integer.parseInt(br.readLine());
                    System.out.println("Enter content of slides :");
                    for(int i=0;i<num;i++){

                        System.out.println("Content of slide " +i +" : ");




                    }

                    //HashMap<String  , ArrayList<String>> tempSlide =temp.getSlide();




                    
                }


            }

            else  if(n==2){


                System.out.println("Please enter the ID of the student :");
                String id=br.readLine();

                student temp =s.get(id);


            }

            else{


                break;
            }
        }


    }

    }
