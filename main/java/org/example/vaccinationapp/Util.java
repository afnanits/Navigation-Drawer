package org.example.vaccinationapp;

import java.util.ArrayList;

//import javax.security.auth.Subject;

public class Util {
    private static ArrayList<NEWS> subjects;
    private static int id=0;
    public Util() {
        if (subjects==null){
            subjects=new ArrayList<>();
            initSubjects();
        }
    }
    public static void initSubjects(){
        String imageUrl="",text="",url="";



        id++;
                subjects.add(new NEWS("https://theprint.in/india/mk-bhan-the-warm-and-helpful-scientist-behind-indias-rotavirus-vaccine/354894/","https://d2c7ipcroan06u.cloudfront.net/wp-content/uploads/2020/01/MK-Bhan-768x432.jpg","New Delhi: Dr Maharaj Kishan Bhan, the man behind India’s first indigenously developed vaccine, passed away this Sunday after battling cancer.\n He was 72.\n" +
                        "\n" +"Bhan is credited with developing a rotavirus vaccine. A former secretary in the \n Department of Biotechnology (DBT), he also transformed India’s biotech programme and set up a number of institutions, enabling industry-academia collaboration in the field. "));

                subjects.add(new NEWS("https://theprint.in/india/mk-bhan-the-warm-and-helpful-scientist-behind-indias-rotavirus-vaccine/354894/","https://d2c7ipcroan06u.cloudfront.net/wp-content/uploads/2020/01/MK-Bhan-768x432.jpg","New Delhi: Dr Maharaj Kishan Bhan, the man behind India’s first indigenously developed vaccine, passed away this Sunday after battling cancer.\n He was 72.\n" + "\n" +"Bhan is credited with developing a rotavirus vaccine. A former secretary in the \n Department of Biotechnology (DBT), he also transformed India’s biotech programme and set up a number of institutions, enabling industry-academia collaboration in the field. "));  //subjects.add(new Subject("e",0,"snns",))
        subjects.add(new NEWS("https://theprint.in/india/mk-bhan-the-warm-and-helpful-scientist-behind-indias-rotavirus-vaccine/354894/","https://d2c7ipcroan06u.cloudfront.net/wp-content/uploads/2020/01/MK-Bhan-768x432.jpg","New Delhi: Dr Maharaj Kishan Bhan, the man behind India’s first indigenously developed vaccine, passed away this Sunday after battling cancer.\n He was 72.\n" +
                "\n" +"Bhan is credited with developing a rotavirus vaccine. A former secretary in the \n Department of Biotechnology (DBT), he also transformed India’s biotech programme and set up a number of institutions, enabling industry-academia collaboration in the field. "));

        subjects.add(new NEWS("https://theprint.in/india/mk-bhan-the-warm-and-helpful-scientist-behind-indias-rotavirus-vaccine/354894/","https://d2c7ipcroan06u.cloudfront.net/wp-content/uploads/2020/01/MK-Bhan-768x432.jpg","New Delhi: Dr Maharaj Kishan Bhan, the man behind India’s first indigenously developed vaccine, passed away this Sunday after battling cancer.\n He was 72.\n" + "\n" +"Bhan is credited with developing a rotavirus vaccine. A former secretary in the \n Department of Biotechnology (DBT), he also transformed India’s biotech programme and set up a number of institutions, enabling industry-academia collaboration in the field. "));  //subjects.add(new Subject("e",0,"snns",))
        subjects.add(new NEWS("https://theprint.in/india/mk-bhan-the-warm-and-helpful-scientist-behind-indias-rotavirus-vaccine/354894/","https://d2c7ipcroan06u.cloudfront.net/wp-content/uploads/2020/01/MK-Bhan-768x432.jpg","New Delhi: Dr Maharaj Kishan Bhan, the man behind India’s first indigenously developed vaccine, passed away this Sunday after battling cancer.\n He was 72.\n" +
                "\n" +"Bhan is credited with developing a rotavirus vaccine. A former secretary in the \n Department of Biotechnology (DBT), he also transformed India’s biotech programme and set up a number of institutions, enabling industry-academia collaboration in the field. "));

        subjects.add(new NEWS("https://theprint.in/india/mk-bhan-the-warm-and-helpful-scientist-behind-indias-rotavirus-vaccine/354894/","https://d2c7ipcroan06u.cloudfront.net/wp-content/uploads/2020/01/MK-Bhan-768x432.jpg","New Delhi: Dr Maharaj Kishan Bhan, the man behind India’s first indigenously developed vaccine, passed away this Sunday after battling cancer.\n He was 72.\n" + "\n" +"Bhan is credited with developing a rotavirus vaccine. A former secretary in the \n Department of Biotechnology (DBT), he also transformed India’s biotech programme and set up a number of institutions, enabling industry-academia collaboration in the field. "));  //subjects.add(new Subject("e",0,"snns",))
        subjects.add(new NEWS("https://theprint.in/india/mk-bhan-the-warm-and-helpful-scientist-behind-indias-rotavirus-vaccine/354894/","https://d2c7ipcroan06u.cloudfront.net/wp-content/uploads/2020/01/MK-Bhan-768x432.jpg","New Delhi: Dr Maharaj Kishan Bhan, the man behind India’s first indigenously developed vaccine, passed away this Sunday after battling cancer.\n He was 72.\n" +
                "\n" +"Bhan is credited with developing a rotavirus vaccine. A former secretary in the \n Department of Biotechnology (DBT), he also transformed India’s biotech programme and set up a number of institutions, enabling industry-academia collaboration in the field. "));

        subjects.add(new NEWS("https://theprint.in/india/mk-bhan-the-warm-and-helpful-scientist-behind-indias-rotavirus-vaccine/354894/","https://d2c7ipcroan06u.cloudfront.net/wp-content/uploads/2020/01/MK-Bhan-768x432.jpg","New Delhi: Dr Maharaj Kishan Bhan, the man behind India’s first indigenously developed vaccine, passed away this Sunday after battling cancer.\n He was 72.\n" + "\n" +"Bhan is credited with developing a rotavirus vaccine. A former secretary in the \n Department of Biotechnology (DBT), he also transformed India’s biotech programme and set up a number of institutions, enabling industry-academia collaboration in the field. "));  //subjects.add(new Subject("e",0,"snns",))



    }
    //private static int id;
    public static ArrayList<NEWS> getAllsubjects(){
        return subjects;
    }



}

