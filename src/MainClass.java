import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

interface googleClassroom{


    public void viewLectureMaterial();
    public void viewAssessments();

    public void viewComments(ArrayList<comments> temp);
  public void addComments(ArrayList<comments> temp ,String time, String name ,String content);

  public void  logout();

    public void printAllFunctions();


}

class student  implements googleClassroom{


    private HashMap<String , quiz> q;
    private HashMap<String, assigment > ass;
    private String id;

    public student (){

        id= "Default";

        ass = new HashMap<>();
        q= new HashMap<>();

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

    public void viewLecture(material mat){

        if(mat.getSlide().isEmpty()){

            System.out.println("No Slides present");


        }

        else {
            for (String i : mat.getSlide().keySet()) {


                System.out.println("Title  :" + i);

                int count = 1;

                for (String j : mat.getSlide().get(i)) {

                    System.out.println("Slide " + count + " : " + j);
                    count++;


                }

                System.out.println("Mose recent Date of upload :" + mat.getTimeSlide().get(i));


            }
        }

        if(mat.getVideo().isEmpty()){
            System.out.println("No Video content present !");
            return;

        }

        System.out.println("The name of the video : " + mat.getVideo().get(this.id));

        System.out.println("Mose recent time of upload :" + mat.getTimeVideo().get(this.id));





    }

    @Override
    public void viewAssessments() {

    }

    public void viewAssessments(teacher t) {


        System.out.println("The lecture material is :");
        t.viewLectureMaterial();

        System.out.println("All the assesments done by you are :");
        System.out.println("Quiz  :");
        for(String i : this.q.keySet()){


            System.out.println(i + " , status  :" +((this.q.get(i).isOpen()) ? "Open" : "Closed") );


        }

        System.out.println("Assigment :");


        for(String i : this.ass.keySet()){


            System.out.println(i+ " , status :" +((this.ass.get(i).isStatus())? "Closed" :"Open" ));

        }



    }

    @Override
    public void viewComments(ArrayList<comments> temp) {

        int j=0;
        for(comments i : temp ){

            System.out.println("Comment no: "+j+" TimeStamp :" +i.getTime() );
            System.out.println("Content :" +i.getContent());
            System.out.println("Name :" +i.getName());

            j++;


        }

    }

    @Override
    public void addComments(ArrayList<comments> temp ,String time, String name ,String content) {


        comments t= new comments();
        t.setName(name);
        t.setTime(time);
        t.setContent(content);
        temp.add(t);
        System.out.println("Comment Added!!");

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

    public  void viewGrades(){


        System.out.println("Graded Assesments :");
        for(String i : this.ass.keySet()){





                System.out.println("Name of assigment : " +i);
                System.out.println("Grade in assigemnt : " + this.ass.get(i).getMarks());
                System.out.println("Graded by :" +this.ass.get(i).getName());





        }

        System.out.println("Graded Quiz :");
        for(String i :this.q.keySet()){



            System.out.println("Name of the Quiz :" +i);
            System.out.println("Grade of the Quiz :" +this.q.get(i).getGrade());
            System.out.println("Graded by  :" +this.q.get(i).getGrade());


        }


    }

    public void setQuizGrade(String grader){




    }


    public void setAssigmentGrade(String grader){




    }

    public void submitAssesment(HashMap<String , teacher> h, BufferedReader br)  throws  Exception{


        ArrayList<assigment> temp = new ArrayList<>();
        int j=0;
        for(String i : h.keySet()){
            HashMap<String, assigment> a=h.get(i).getAss();
            for(String k : a.keySet()){



                System.out.println("ID :" +j + " Name : "+a.get(k).getName());
                temp.add(a.get(k));
                j++;

            }





        }

        System.out.println("Enter the ID for assesement :");
        int n=Integer.parseInt(br.readLine());
        System.out.println("Enter the file name for submittion :");
        String fileName =br.readLine();
        assigment studentSubmission =temp.get(n);
        studentSubmission.setSubmitted(true);
        studentSubmission.setFileName(fileName);






    }

    public void submitQuiz(HashMap<String , teacher> h, BufferedReader br)  throws  Exception{


        ArrayList<quiz> temp = new ArrayList<>();
        int j=0;
        for(String i : h.keySet()){
            HashMap<String, quiz> a=h.get(i).getQ();
            for(String k : a.keySet()){



                System.out.println("ID :" +j + " Name : "+a.get(k).getName());
                temp.add(a.get(k));
                j++;

            }





        }


        System.out.println("Enter the ID for Quiz :");
        int n=Integer.parseInt(br.readLine());
       System.out.println("Enter the answer");
        String fileName =br.readLine();
        quiz studentSubmission =temp.get(n);
        studentSubmission.setStatus(true);
        studentSubmission.setAnswer(fileName);






    }





    public HashMap<String, quiz> getQ() {
        return q;
    }

    public void setQ(HashMap<String, quiz> q) {
        this.q = q;
    }

    public HashMap<String, assigment> getAss() {
        return ass;
    }

    public void setAss(HashMap<String, assigment> ass) {
        this.ass = ass;
    }
}

class teacher implements googleClassroom
{


    private material mat;

    private HashMap<String , quiz> q;

    private HashMap<String, assigment > ass;



    private String id;


public teacher(){

    id="Default";
    mat= new material();
    q= new HashMap<>();
    ass= new HashMap<>();


}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public void viewLectureMaterial() {


    if(this.mat.getSlide().isEmpty()){

        System.out.println("No Slides present");


    }

    else {
        for (String i : this.mat.getSlide().keySet()) {


            System.out.println("Title  :" + i);

            int count = 1;

            for (String j : this.mat.getSlide().get(i)) {

                System.out.println("Slide " + count + " : " + j);
                count++;


            }

            System.out.println("Mose recent Date of upload :" + this.mat.getTimeSlide().get(i));


        }
    }

    if(this.mat.getVideo().isEmpty()){
        System.out.println("No Video content present !");
        return;

    }

for(String i :this.mat.getVideo().keySet()){

    System.out.println("Name of Video :" +i);
    System.out.println("Last time of edit :" +this.mat.getTimeVideo().get(i));



}



    }

    @Override
    public void viewAssessments() {

    System.out.println("The lecture material is :");
    this.viewLectureMaterial();

System.out.println("All the assesments done by you are :");
System.out.println("Quiz  :");
for(String i : this.q.keySet()){


    System.out.println(i + " , status  :" +((this.q.get(i).isOpen()) ? "Open" : "Closed") );



}

System.out.println("Assigment :");


for(String i : this.ass.keySet()){


    System.out.println(i+ " , status :" +((this.ass.get(i).isStatus())? "Closed" :"Open" ));
    System.out.println("Max Marks :" +this.ass.get(i).getMaxMarks());


}






    }

    @Override
    public void viewComments(ArrayList<comments> temp) {
     int j=0;
    for(comments i : temp ){

        System.out.println("Comment no: "+j+" TimeStamp :" +i.getTime() );
        System.out.println("Content :" +i.getContent());
        System.out.println("Name :" +i.getName());
        j++;


    }

    }

    @Override
    public void addComments(ArrayList<comments> temp ,String time, String name ,String content) {


        comments t= new comments();
        t.setName(name);
        t.setTime(time);
        t.setContent(content);
        temp.add(t);
        System.out.println("Comment Added!!");

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

            this.mat.getSlide().put(topic, topicSlides);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            this.mat.getTimeSlide().put(topic ,dtf.format(now));





        }

        else if(choice ==2){


            System.out.println("Enter the topic of the video: ");
            String  topic= br.readLine();
            System.out.println("Enter the name of the video :");
            String videoContent =br.readLine();
            this.mat.getVideo().put(topic ,videoContent);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            this.mat.getTimeVideo().put(topic, dtf.format(now));



        }

        else{


            return ;


        }


    }



    public void addQuiz(BufferedReader br, HashMap<String, quiz> h ,String topic ,HashMap<String , student> st  ) throws Exception {





        quiz  qu= new quiz();
        qu.setName(topic);
        qu.setStatus(false);


        if(ass.containsKey(topic)){
            h.put(topic, qu);
            return ;


        }

        this.q.put(topic, qu);
        h.put(topic, qu);
        for(String i : st.keySet()){

            st.get(i).getQ().put(topic, qu);

        }






    }

        public void addAssesment(BufferedReader br, HashMap<String , assigment> h,  String topic , int n , HashMap<String, student> st) throws  Exception{





            assigment temp = new assigment();

            temp.setName(topic);

            temp.setMaxMarks(n);

            if(ass.containsKey(topic)){
                h.put(topic, temp);
                return ;


            }
            this.ass.put(topic, temp);
            h.put(topic, temp);

            for(String i : st.keySet()){

                st.get(i).getAss().put(topic ,temp);


            }




        }








    public void gradeAssesment(quiz temp , BufferedReader br) throws  Exception{




        if(!temp.isStatus()){
            System.out.println("No submissions were given ");


        }

        else {

            System.out.println("Submission :" + temp.getAnswer());

        }

        System.out.println("Give grade :");
        int n=Integer.parseInt(br.readLine());

        if(n!=1 && n!=0){
            System.out.println("The grade given must be 1 or 0 for quiz!!");
            return ;
        }
        temp.setGrade(n);
        temp.setStatus(true);



    }

    public void gradeAssesment(assigment temp ,BufferedReader br) throws  Exception{


    if(!temp.isSubmitted()){
        System.out.println("No submissions were given ");

    }

    else {

        System.out.println("Submission :" + temp.getFileName());

    }

    System.out.println("Give grade :");
    int n=Integer.parseInt(br.readLine());

        if(n >temp.getMaxMarks()){
            System.out.println("The grade given must less than max marks!!");
            return ;


        }

        temp.setMarks(n);
        temp.setStatus(true);



    }

    public void closeAssesment(assigment temp ,BufferedReader br) throws  Exception{



    if(!temp.isStatus()){
        System.out.println("The assigemnt has already been closed");
        return ;

    }
    temp.setStatus(true);

    System.out.println("The assigment has been closes !!");



    }

    public void closeAssesment(quiz temp ,BufferedReader br) throws  Exception{

        if(!temp.isStatus()){
            System.out.println("The quiz has already been closed");
            return ;

        }

    temp.setStatus(true);

    System.out.println("The quiz has been closed!!");


    }

    public material getMat() {
        return mat;
    }

    public void setMat(material mat) {
        this.mat = mat;
    }

    public HashMap<String, quiz> getQ() {
        return q;
    }

    public void setQ(HashMap<String, quiz> q) {
        this.q = q;
    }

    public HashMap<String, assigment> getAss() {
        return ass;
    }

    public void setAss(HashMap<String, assigment> ass) {
        this.ass = ass;
    }
}





class material{

private HashMap<String , String> timeSlide = new HashMap<>();
private HashMap<String ,String> timeVideo = new HashMap<>();
private String nameSlide;
private String nameVideo;
private HashMap<String, ArrayList<String>> slide = new HashMap<>();
private HashMap<String, String> video = new HashMap<>();


    public HashMap<String , String> getTimeSlide() {
        return timeSlide;
    }

    public void setTimeSlide(HashMap<String , String>time) {
        this.timeSlide = time;
    }


    public String getNameSlide() {
        return nameSlide;
    }

    public void setNameSlide(String nameSlide) {
        this.nameSlide = nameSlide;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public HashMap<String, ArrayList<String>> getSlide() {
        return slide;
    }

    public void setSlide(HashMap<String, ArrayList<String>> slide) {
        this.slide = slide;
    }

    public HashMap<String, String> getVideo() {
        return video;
    }

    public void setVideo(HashMap<String, String> video) {
        this.video = video;
    }

    public HashMap<String , String> getTimeVideo() {
        return timeVideo;
    }

    public void setTimeVideo(HashMap<String , String>timeVideo) {
        this.timeVideo = timeVideo;
    }
}

class quiz{
    private boolean open=true;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    String grader;
    String adder ;

    public String getGrader() {
        return grader;
    }

    public void setGrader(String grader) {
        this.grader = grader;
    }

    public String getAdder() {
        return adder;
    }

    public void setAdder(String adder) {
        this.adder = adder;
    }

    private String name;
 private boolean status;
 private String answer;
 private int grade=0;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public quiz(){

     this.status =false;
     this.open =true;


 }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class assigment{

private String grader;

    public String getGrader() {
        return grader;
    }

    public void setGrader(String grader) {
        this.grader = grader;
    }

    private boolean status=false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String fileName;
    private String name;
    private int maxMarks;
    private int marks=0;
    private boolean submitted=false;


    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public String getFileName() {

        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}


class comments {

    private String time;
    private  String name;
    private String content ;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


public class MainClass {

    public static void main(String arg[]) throws Exception {

        ArrayList<comments> comm = new ArrayList<>();


        HashMap<String, teacher> t = new HashMap<>();
        t.put("I0", new teacher());
        t.get("I0").setId("I0");
        t.put("I1", new teacher());
        t.get("I1").setId("I1");
        HashMap<String, student> s = new HashMap<>();

        s.put("S0", new student());

        s.get("S0").setId("S0");
        s.put("S1", new student());
        s.get("S1").setId("S1");
        s.put("S2", new student());

        s.get("S2").setId("S2");

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);


        while (true) {


                System.out.println("Welcome to Backpack\n" +
                        "1. Enter as instructor\n" +
                        "2. Enter as student\n" +
                        "3. Exit");
                int n = Integer.parseInt(br.readLine());
                if (n == 1) {

                    boolean running = true;
                    System.out.println("Plesase Enter the ID of instructor: ");
                    String id = br.readLine();
                    teacher temp = t.get(id);

                    System.out.println("Welcome : " + id);
                    while (running) {

                        temp.printAllFunctions();
                        System.out.println("Enter the function to perform :");
                        switch (Integer.parseInt(br.readLine())) {

                            case 1:
                                temp.addLectureAndVideo(br);
                                break;
                            case 2:

                                System.out.println("1. Add Assignment\n" +
                                        "2. Add Quiz");

                                int choice = Integer.parseInt(br.readLine());

                                if (choice == 1) {
                                    System.out.println("Enter problem statement : ");

                                    String topic = br.readLine();

                                    System.out.println("Enter the max marks:");
                                    int marks = Integer.parseInt(br.readLine());

                                    for (String i : s.keySet()) {
                                        temp.addAssesment(br, s.get(i).getAss(), topic, marks ,s);
                                    }

                                } else if (choice == 2) {


                                    System.out.println("Enter Quiz Question : ");

                                    String topic = br.readLine();
                                    for (String i : s.keySet()) {
                                        temp.addQuiz(br, s.get(i).getQ(), topic ,s);
                                    }

                                }


                                break;
                            case 3:
                                temp.viewLectureMaterial();
                                break;
                            case 4:
                                temp.viewAssessments();
                                break;
                            case 5:


                                for (String i : s.keySet()) {


                                    System.out.println(i);


                                }
                                System.out.println("Enter the name of the student you want to grade :");
                                String studentName = br.readLine();
                                student st = s.get(studentName);

                                System.out.println("Do you want to grade the assigment(1) or Quiz(2) :");
                                int get= Integer.parseInt(br.readLine());
                                if(get ==1){


                                    for(String i : st.getAss().keySet()){
                                        System.out.println("Name :" +st.getAss().get(i).getName());


                                    }
                                    System.out.println("Enter the name of the assigemnt you want to grade: ");
                                    String assName=br.readLine();

                                    temp.gradeAssesment( st.getAss().get(assName),br);

                                }

                                else{

                                    for(String i : st.getQ().keySet()){
                                        System.out.println("Name :" +st.getQ().get(i).getName());


                                    }

                                    System.out.println("Enter the name of the quiz you want to grade :");
                                    String qName =br.readLine();
                                    temp.gradeAssesment(st.getQ().get(qName) ,br);

                                }

                                break;

                            case 6:


                                System.out.println("Do you want to close a Assigment or quiz :");
                                int ch =Integer.parseInt(br.readLine());

                                if(ch==1){


                                    for(String i : temp.getAss().keySet()){

                                        System.out.println("Name : "+i);


                                    }


                                    System.out.println("Enter the name of the assigment you want to close :");
                                    String  name =br.readLine();
                                    temp.closeAssesment(temp.getAss().get(name) ,br);

                                }

                                else{

                                    for(String i : temp.getQ().keySet()){

                                        System.out.println("Name :" +i);


                                    }

                                    System.out.println("Enter the name of the quiz you want to close");
                                    String name= br.readLine();
                                    temp.closeAssesment(temp.getQ().get(name), br);


                                }
                                break;



                            case 7:

                                temp.viewComments(comm);
                                break;
                            case 8:
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();

                                System.out.println("Add comment :");
                                String c = br.readLine();
                                temp.addComments(comm, dtf.format(now), id, c);
                                break;
                            case 9:
                                running = false;
                                break;


                        }
                    }

                } else if (n == 2) {


                    boolean running =true;
                    System.out.println("Plesase Enter the ID of  student : ");
                    String id = br.readLine();
                    student temp = s.get(id);

                    System.out.println("Welcome : " + id);
                    while(running ){


                        temp.printAllFunctions();
                        System.out.println("Enter the function to perform :");

                        switch(Integer.parseInt(br.readLine())){


                            case 1:
                                for(String i  : t.keySet()){

                                    System.out.println("Instructor :"
                                    + i);
                                   t.get(i).viewLectureMaterial();


                                }

                                break;
                            case 2:
                                for(String i : t.keySet()){


                                    temp.viewAssessments(t.get(i));
                                }

                                break;
                            case 3:

                                System.out.println("Do you want to submit Assigemnt(1) or Quiz(2)");
                                int f=Integer.parseInt(br.readLine());
                                if(f==1){


                                    temp.submitAssesment(t ,br);
                                }
                                else {
                                    temp.submitQuiz(t, br);
                                }
                                break;
                            case 4:
                                temp.viewGrades();
                                break;
                            case 5:
                                temp.viewComments(comm);

                                break;
                            case 6:
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();

                                System.out.println("Add comment :");
                                String c = br.readLine();
                                temp.addComments(comm, dtf.format(now), id, c);
                                break;
                            case 7:
                                temp.logout();
                                running=false;



                        }



                    }


                } else {
                    System.out.println("Exiting the program !!");

                    break;


                }


            }

        }
    }


