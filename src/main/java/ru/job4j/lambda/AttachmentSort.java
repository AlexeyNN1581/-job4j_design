package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 1", 34),
                new Attachment("image 2", 13)
        );
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());

            }

        };
        attachments.sort(comparator);
        System.out.println(attachments);
        // Здесь создайте компаратор на основании анонимного класса.
        System.out.println();


        Comparator<Attachment> comparator2 = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {

                System.out.println(o1.getName()+" "+o2.getName());
                System.out.println(o1.getName().compareTo(o2.getName()));
                return o1.getName().compareTo(o2.getName());
            }

        };


        attachments.sort(comparator2);
    }


}


