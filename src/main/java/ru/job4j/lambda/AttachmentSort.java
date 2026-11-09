package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
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
                int resultSize;
                if (o1.getSize() < o2.getSize()) {
                    resultSize=o2.getSize()- o1.getSize();
                    System.out.println("Размер " + o1.getName() + " меньше размера " + o2.getName() + " на: "+resultSize );
                    return o2.getSize() - o1.getSize();
                } else if (o1.getSize() > o2.getSize()) {
                    resultSize=o1.getSize()- o2.getSize();
                    System.out.println("Размер " + o1.getName() + " больше размера " + o2.getName() + " на:"+resultSize);
                    return resultSize;

                } else{
                    System.out.println("Размер " + o1.getName() + " равен размеру " + o2.getName() + " и равен:");
                return o1.getSize();

            }
}

        };


        attachments.sort(comparator2);
    }


}


