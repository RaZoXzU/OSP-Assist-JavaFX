package osp;

import osp.Models.Action;
import osp.Models.FunctionName;
import osp.Models.Member;
import osp.Models.MembersFunctions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class HibernateTestIinit {
    public static void startTest() {
        System.out.println("Start testu Hibernate");
        //insertTest();
        //connectFunctionWithMember(2);
    }

    private static void insertFunctionName(String name){
        FunctionName functionName = new FunctionName();
        functionName.setName(name);
        insertObjectIntoDB(functionName);
    }

    private static void insertTest() {
        LocalDateTime dateStart = LocalDateTime.of(2020, 5, 23, 9, 23);
        LocalDateTime dateStop = LocalDateTime.of(2020, 5, 23, 10, 23);
        LocalDate date = LocalDate.of(2020, 5, 23);
        insertAction("1/2020", 1, "Pożar sadzy w kominie", "Janowo 15", "Uszkodzony wycior",dateStart,dateStop);
        insertAction("2/2020", 2, "Zerwany dach", "Strubiny 3","",dateStart,dateStop);
        insertAction("3/2020", 3, "Alarm fałszywy", "Wojszczyce 1", "",dateStart,dateStop);
        insertAction("4/2020", 4, "Cwiczenia z PSP", "Modlin", "",dateStart,dateStop);
        insertAction("5/2020", 5, "Podlewanie placu", "Janowo", "",dateStart,dateStop);

        insertFunctionName("Strażak");
        insertFunctionName("Starszy Strażak");
        insertFunctionName("Dowódca Roty");
        insertFunctionName("Pomocnik Dowódcy Sekcji");
        insertFunctionName("Dowódca Sekcji");
        insertFunctionName("Pomocnik Dowódcy Plutonu");
        insertFunctionName("Dowódca Plutonu");
        insertFunctionName("Członek Komisji Rewizyjnej");
        insertFunctionName("Przewodniczący Komisji Rewizyjnej");
        insertFunctionName("Członek Zarządu");
        insertFunctionName("Zastępca Naczelnika");
        insertFunctionName("Naczelnik");
        insertFunctionName("Wiceprezes");
        insertFunctionName("Prezes");

        insertMember("Janusz", "Kowalski","Jan","Warszawa" , date,
                "12345678912","Marki 23/23","AXJ37432" , 123123123,
                date, false, true, true);
        insertMember("Jan", "Wiśniowiecki","Mateusz","Gdańsk" , date,
                "45372819561","Nadmorska 3","AXJ98765" , 321654987,
                date, false, true, true);
        insertMember("Paweł", "Jadczak","Mateusz","Kraków" , date,
                "19537289341","Głuchołazy 15a","AXJ54321" , 123789345,
                date, false, true, true);
        insertMember("Łukasz", "Starzewski","Romuald","Wiśniewo" , date,
                "92856735218","Radziejowice 18","AJX34132" , 567345456,
                date, false, true, true);
        insertMember("Konstanty", "Radziwił","Artur","Warszawa" , date,
                "92549114273","Średniowieczna 2","AXJ12345" , 123234345,
               date, false, true, true);



    }
    public static void insertMember(String firstName, String lastName, String fatherName, String birthCity
            , LocalDate birthday, String pesel , String adress, String idCardNumber, Integer phoneNumber
            , LocalDate joinDate, Boolean isJOT, Boolean isMember, Boolean isMan){
        Member member = new Member();
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setFatherName(fatherName);
        member.setBirthCity(birthCity);
        member.setBirthday(birthday);
        member.setPesel(pesel);
        member.setAdress(adress);
        member.setIdCardNumber(idCardNumber);
        member.setPhoneNumber(phoneNumber);
        member.setJoinDate(joinDate);
        member.setJOT(isJOT);
        member.setMember(isMember);
        member.setMan(isMan);
        insertObjectIntoDB(member);

    }

    public static void insertAction(String number, Integer type, String title, String adress, String caption, LocalDateTime start, LocalDateTime stop) {
        Action akcja = new Action();
        akcja.setRegNumber(number);
        akcja.setType(type);
        akcja.setTitle(title);
        akcja.setAddress(adress);
        akcja.setCaption(caption);
        akcja.setDateStart(start);
        akcja.setDateStop(stop);

        insertObjectIntoDB(akcja);
    }

    private static void insertObjectIntoDB(Object object) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ospa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void connectFunctionWithMember(Integer id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ospa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Member member = new Member();
        FunctionName functionName = new FunctionName();
        MembersFunctions membersFunctions = new MembersFunctions();
        LocalDateTime dateStart = LocalDateTime.of(2020, 5, 23, 9, 23);

        List<FunctionName> listFN = entityManager.createQuery("FROM Function_Names WHERE id="+id).getResultList();
        for (int i=0; i<listFN.size();i++){
            System.out.println(listFN.get(i));
            functionName=listFN.get(i);
        }
        List<Member> listMember = entityManager.createQuery("FROM Members WHERE id="+id).getResultList();
        for (int i=0; i<listMember.size();i++){
            System.out.println(listMember.get(i));
            member = listMember.get(i);
        }

        membersFunctions.setDateFunction(dateStart);
        membersFunctions.setIdFunctionName(functionName);
        membersFunctions.setIdMember(member);

        entityManager.persist(membersFunctions);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void selectFunctionWithMember(Integer id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ospa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Member member = new Member();
        FunctionName functionName = new FunctionName();
        MembersFunctions membersFunctions = new MembersFunctions();
        LocalDateTime dateStart = LocalDateTime.of(2020, 5, 23, 9, 23);

        List<FunctionName> listFN = entityManager.createQuery("FROM Function_Names WHERE id="+id).getResultList();
        for (int i=0; i<listFN.size();i++){
            System.out.println(listFN.get(i));
            functionName=listFN.get(i);
        }
        List<Member> listMember = entityManager.createQuery("FROM Members WHERE id="+id).getResultList();
        for (int i=0; i<listMember.size();i++){
            System.out.println(listMember.get(i));
            member = listMember.get(i);
        }

        membersFunctions.setDateFunction(dateStart);
        membersFunctions.setIdFunctionName(functionName);
        membersFunctions.setIdMember(member);

        entityManager.persist(membersFunctions);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
