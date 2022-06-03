package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class References {

    public static void main(String[] args) {
        /*
         * example - strong reference
         * */
        String example = "value";
        WeakReference<String> weakReference = new WeakReference<>(example);
        SoftReference<String> softReference = new SoftReference<>(example);
        System.out.println(example);
        System.out.println(weakReference.get());
        System.out.println(softReference.get());

        /*
         * значение изменено, безопасные и слабые ссылки ссылаются на первоначальное значение
         * */
        example = "new value";
        System.gc();
        System.out.println(example);
        System.out.println(weakReference.get());
        System.out.println(softReference.get());

        /*
         * удаляем сильную ссылку, безопасные и слабые ссылки ссылаются на первоначальное значение,
         * тк. безопасная ссылка удаляется только если нужно высвободить память
         * */
        example = null;
        System.gc();
        System.out.println(example);
        System.out.println(weakReference.get());
        System.out.println(softReference.get());

        /*
         * удаляем безопасную ссылку, удаляестся слабая
         * */
        System.out.println(example);
        softReference.clear();
        System.gc();
        System.out.println(softReference.get());
        System.out.println(weakReference.get());
    }
}
