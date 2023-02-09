import uz.pdp.Instagram.model.User;
import uz.pdp.Instagram.model.post.Post;
import uz.pdp.Instagram.repository.PostRepository;
import uz.pdp.Instagram.repository.UserRepository;
import uz.pdp.Instagram.service.followersservice.FollowersService;
import uz.pdp.Instagram.service.followersservice.FollowersServiceImpl;
import uz.pdp.Instagram.service.postservice.PostService;
import uz.pdp.Instagram.service.postservice.PostServiceImpl;
import uz.pdp.Instagram.service.userservice.UserService;
import uz.pdp.Instagram.service.userservice.UserServiceImpl;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import static uz.pdp.Instagram.model.post.PostType.*;

public class Main {
    static UserService userService = new UserServiceImpl();
    static PostService postService = new PostServiceImpl();
    static FollowersService followersService = new FollowersServiceImpl();

    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);
    static Random random = new Random();
    static UUID ID=null;
    static Random likes=new Random();

    public static void main(String[] args) {
        while(true){
        System.out.println("1-Sign up\t2-Sign In\t\t0.Exit");
        int act = scanInt.nextInt();

            switch (act) {
                case 1 -> {
                    signUp();
                }
                case 2 -> {
                    signIn();
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void signIn() {
        System.out.print("Enter username: ");
        String username = scanStr.nextLine();
        System.out.print("Enter password: ");
        String password = scanStr.nextLine();
       {
            if (userService.getByuser(username,password)!=null) {
                ID=userService.getid(username);
                userMenu();

            }
            else {
                System.out.println("We did not find this user ❌");

            }
        }
    }

    private static void userMenu() {
        System.out.println("1-My posts\t2-My accounts\t3-My followers\t4-My likes\t5-Search\t0-Back");
        int act=scanInt.nextInt();
        while (true) {
            switch (act) {
                case 1 -> myPosts();
                case 2 -> myAcc();
                case 3 -> myFollowers();
                case 4 -> myLikes();
                case 5 -> search();
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Wrong Command ❌");
                    return;
                }
            }
        }
    }

    private static void search() {

    }

    private static void myLikes() {

    }

    private static void myFollowers() {

    }

    private static void myAcc() {


    }

    private static void myPosts() {
            while (true) {
            System.out.println("1.Show Posts\t2.Create Post\t3.Delete Post\t4.Comment\t5.Like Post\t0.Back");
            switch (scanInt.nextInt()){
                case 1->{
                    showPost();
                }
                case 2->{
                    createPost();
                }
                case 3->{
                    deletePost();
                }
                case 4->{
                    commentPost();
                }
                case 5->{
                    likePost();
                }
                case 0->{
                    return;
                }
                default -> {
                    System.out.println("Wrong Command ❌");
                    return;
                }
            }
        }
    }

    private static void likePost() {
    }

    private static void commentPost() {
    }

    private static void deletePost() {
    }

    private static void createPost() {
        System.out.print("Choose type post(P,R,V): ");
        String type=scanStr.nextLine();
        System.out.print("Enter description: ");
        String description=scanStr.nextLine();
        if (type.equals("P")){
            Post post = new Post(PHOTO,UUID.randomUUID(),description,likes.nextInt(10000,999999));
            postService.add(post);
            System.out.println("Created Successfully ✅");
        }
        else if (type.equals("R")){
            Post post = new Post(REELS,UUID.randomUUID(),description,likes.nextInt(10000,999999));
            postService.add(post);
            System.out.println("Created Successfully ✅");
        }
        else if (type.equals("V")){
            Post post = new Post(VIDEO,UUID.randomUUID(),description,likes.nextInt(10000,999999));
            postService.add(post);
            System.out.println("Created Successfully ✅");
        }
        else {
            System.out.println("Wrong Type ❌");
        }
    }

    private static void showPost() {
        for (int i = 0; i < PostRepository.posts.size(); i++) {
            if (PostRepository.posts.get(i) == null){
                System.out.println("You have no posts yet ❗");
            }else {
                System.out.println(PostRepository.posts.get(i));
            }
        }
    }
    private static void signUp() {
        System.out.println("Choose the type of signing up:");
        System.out.println("1-With Gmail\t\t2-With Phone number\t\t0-Back");
        int act1 = scanInt.nextInt();
        while (true){
            switch (act1) {
                case 1 -> gmailUp();
                case 2 -> phoneUp();
                case 0 -> {
                    return;
                }
            }
        }
    }


    private static void phoneUp() {
        System.out.print("Enter full name: ");
        String fullname = scanStr.nextLine();
        System.out.print("Enter phone number: (+998) ");
        String phoneNumber = scanStr.nextLine();
        if (phoneNumber.length()==9){
            while (true){
                String randomNum = "bKtF"+ random.nextInt(1000,9999) + "-HmQd";
                System.out.println("Your SMS code: " + randomNum);
                System.out.print("Enter SMS code: ");
                String smscode= scanStr.nextLine();
                if (smscode.equals(randomNum)){
                    System.out.println("SMS ✅");
                    break;
                }
                else {
                    System.out.println("Incorrect SMS code ❌");
                }
            }
            System.out.print("Enter username: ");
            String username= scanStr.nextLine();
            System.out.print("Enter your own password: ");
            String password= scanStr.nextLine();
            User user = new User(username,password,phoneNumber,fullname);
            userService.add(user);
            System.out.println("Sign Up Successfully ✅");
             userMenu();
        }
        else {
            System.out.println("Phone Number is Wrong !  Try Again !");
        }
    }
    private static void gmailUp() {
        while(true){
            System.out.print("Enter your gmail:  ");
            String gmail=scanStr.nextLine();
            if (gmail.endsWith("@gmail.com")){System.out.print("Enter your username:  ");
                String username=scanStr.nextLine();
                for (int i = 0; i < UserRepository.users.size(); i++) {
                    if (UserRepository.users.get(i).getUsername().equals(username)){
                        System.out.println("This username has already used ❌");
                        return;
                    } else {
                        System.out.print("Create a password:  ");
                        String password=scanStr.nextLine();
                        if (password.length()>=8){
                           if(userService.add(new User(username,password,gmail))==1) {
                               System.out.println("Successfully saved your account");
                               userMenu();
                           }
                        }
                        else {
                            System.out.println("Password length must be more 8 character !");
                            return;
                        }
                    } } }
            else {

                System.out.println("\nWrong something. Try Again ❌\n" );
            }
        }
    }
     static{
        userService.add(new User("hgghghjh","dli1999"));
        userService.add(new User("mittime","mittivine"));
        userService.add(new User("cristiano","cr7family"));
            }
        }

