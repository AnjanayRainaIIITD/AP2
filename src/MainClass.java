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

    public void printAllFunctions();


}

class student  implements googleClassroom{


    private String id;
    public student (){
        id= "Default";


    }

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

    @Override
    public void printAllFunctions() {


        System.out.println("1. View lecture materials\n" +
                "2. View assessments\n" +
                "3. Submit assessment\n" +
                "4. View grades\n" +
                "5. View comments\n" +
                "6. Add comments\n" +
                "7. Logout");

    }


}

class teacher implements googleClassroom {


    private HashMap<String, ArrayList<String>> slide = new HashMap<>();
    private HashMap<String, String> video = new HashMap<>();
    private HashMap<String , ArrayList<Integer>> assigment = new HashMap<>();



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

    public HashMap<String, ArrayList<Integer>> getAssigment() {
        return assigment;
    }

    public void setAssigment(HashMap<String, ArrayList<Integer>> assigment) {
        this.assigment = assigment;
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


    public void printAllFunctions() {

        System.out.println("1. Add class material\n" +
                "2. Add assessments\n" +
                "3. View lecture materials\n" +
                "4. View assessments\n" +
                "5. Grade assessments\n" +
                "6. Close assessment\n" +
                "7. View comments\n" +
                "8. Add comments\n" +
                "9. Logout");


    }


    public void addLectureAndVideo( BufferedReader br ) throws Exception {

        System.out.println("1. Add Lecture Slide\n" +
                "2. Add Lecture Video");

        int choice  =Integer.parseInt(br.readLine());
        if(choice ==1){

            System.out.println("Enter topic of slides: ");

            String topic= br.readLine();
            ArrayList<String > topicSlides= new ArrayList<>();
            System.out.println("Enter number of slides:");
            int n=Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){

                System.out.println("Content of Slide " +(i+1) +" :");

                topicSlides.add(br.readLine());



            }

            this.slide.put(topic,topicSlides);





        }

        else if(choice ==2){


System.out.println("Enter the topic of the video: ");
String  topic= br.readLine();
System.out.println("Enter the name of the video :");
String videoContent =br.readLine();
this.video.put(topic ,videoContent);



        }

        else{

            return ;


        }


    }



    public void addAssesment(BufferedReader br) throws Exception{



        System.out.println("1. Add Assignment\n" +
                "2. Add Quiz");

        int choice  =Integer.parseInt(br.readLine());
        if(choice ==1){

            System.out.println("Enter problem statement : ");

            String topic= br.readLine();

            System.out.println("Enter the max marks:");
            int n=Integer.parseInt(br.readLine());
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(n);



            this.assigment.put(topic,temp);





        }

        else if(choice ==2){


            System.out.println("Enter the topic of the video: ");
            String  topic= br.readLine();
            System.out.println("Enter the name of the video :");
            String videoContent =br.readLine();
            this.video.put(topic ,videoContent);



        }

        else{

            return ;


        }



    }
}






public class MainClass {

    public static void main(String arg[]) throws Exception {


        HashMap<String, teacher> t = new HashMap<>();
        t.put("I0" ,new teacher());
        t.put("I1", new teacher());

        HashMap<String, student> s = new HashMap<>();

        s.put("S0", new student());
        s.put("S1", new student());
        s.put("S2", new student());


        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);


        while (true) {
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {

                System.out.println("Plesase Enter the ID of instructor: ");
                String id = br.readLine();
                teacher temp = t.get(id);

                System.out.println("Welcome : " + id);
                temp.printAllFunctions();
                System.out.println("Enter the function to perform :");
                switch(Integer.parseInt(br.readLine())){

                    case 1 :
                        temp.addLectureAndVideo(br);
                    case 2:

                }

            }

            else if(n==2){


            }

            else{
                System.out.println("Logging Out!!");

                break;


            }


        }

    }
}
