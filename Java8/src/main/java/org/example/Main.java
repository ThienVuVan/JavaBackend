package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Main {
    // stream api
    // lamda expression
    // method reference
    // Optional
    // Functional Interface
    // Biết các thứ này code sẽ dễ và ngắn gọn hơn nhiều.
    public static void main(String[] args) {
//        CreateStreamForPrimitive();
//        CreateStreamForReference();
//        ConvertUsingStream();
//        Iterate();
//        Filter();
//        Map();
//        Sort();
//        Match();
//        Count();
//        MinMax();
//        SummaryStatistics();
        ComparatorAndPredicate();
    }

    public static void CreateStreamForPrimitive(){
        IntStream.range(1,5).forEach(System.out::println);
        System.out.println(LongStream.range(1,9).filter(i -> i%2==0).count());
        DoubleStream.of(1,2,3,4).forEach(System.out::println);
        // System.out::println gọi là method reference.
    }
    public static void CreateStreamForReference(){
//        /* for array */
//        String[] arr = {"thien", "thinh", "luong"};
//        // get by Array.stream
//        Stream<String> stream = Arrays.stream(arr);
//        stream.forEach(System.out::println);
//        Arrays.stream(arr).forEach(System.out::println);
//        // get by Stream.of
//        Stream<String> stream1 = Stream.of(arr);
//        stream1.forEach(System.out::println);

        /* for collection */
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
        List<Integer> list1 = list.stream().sorted((a,b) -> b-a).collect(Collectors.toList());
        list1.stream().forEach(System.out::println);
        list.parallelStream().forEach(System.out::println);
    }
    public static void ConvertUsingStream(){
        Stream<String> streams = Stream.of("thien", "thinh", "luong");
        List<String> name = streams.collect(Collectors.toList());
        Stream<String> stream1 = Stream.of("thien", "thinh", "luong");
        String[] array = stream1.toArray(String[]::new);
        name.forEach(System.out::println);
        Arrays.stream(array).forEach(System.out::println);
    }
    public static void Filter(){
        // filter trả về stream đối tượng nguồn, không biến đổi đối tượng
        Stream.iterate(1, i -> i+1).limit(20).filter(i -> i%2==0).forEach(System.out::println);
    }
    public static void Iterate(){
        // skip: start at 5. skip all element before 5.
        // limit: max returned element in stream is 10.
        Stream.iterate(0, i -> i+1).skip(5).limit(10).forEach(System.out::println);
    }
    public static void Map(){
        // map sẽ trả về stream đối tượng kiểu mới hoặc không
        Set<Integer> mySet = Set.of(1,2,3,4,5,6,7,8,9);
        mySet.stream().map(i -> i%2==0).forEach(System.out::println);
        List<String> names = List.of("thien", "thinh", "luong");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
    public static void Sort(){
        int[] a = {5,9,0,3,6,2,3,2};
        Arrays.stream(a).sorted().forEach(System.out::println);
        System.out.println(Arrays.stream(a).sum());
        List<Integer> nums = List.of(4,7,9,2,4,7);
        nums.stream().sorted((x,y) -> y-x).forEach(System.out::println);
        // (x,y) -> y-x là triển khai hàm compare của comparator interface.
        // x-y -> nếu true đổi chỗ, false giữ nguyên.
        // lưu ý đối với sorted, không dùng được paralellStream bới vì các đối tượng so sánh cần đuojc chạy trong một luồng.
    }
    public static void Match(){
        double[] a = {1,3.4,6,75.9};
        System.out.println(Arrays.stream(a).anyMatch(i -> i == 3.4)); // true
        List<String> names = List.of("thien", "thinh", "luong");
        System.out.println(names.stream().anyMatch(e -> e.equalsIgnoreCase("luong"))); // true
        System.out.println(names.stream().noneMatch(e -> e.equalsIgnoreCase("nguyen"))); // true
        int[] b = {1,1,1};
        System.out.println(Arrays.stream(b).allMatch(e -> e == 1)); // true
    }
    public static void Count(){
        Map<Integer, String> myMap = Map.of(1,"thien", 2, "thinh", 3, "luong", 4,"nguyen");
        long count = myMap.entrySet().stream().filter(m -> m.getValue().length() > 0).count();
        System.out.println(count);
        // entryset return set of map<K,V>;
        // keyset return set of key;

    }
    public static void MinMax(){
        int[] a = {5,9,0,3,6,2,3,2};
        System.out.println(Arrays.stream(a).max().getAsInt());
        List<Integer> nums = List.of(5,9,7,8,2,5);
        int max = nums.stream().max(Comparator.comparing(Integer::valueOf)).get();
        int max1 = nums.stream().max((x,y) -> y-x).get();
        // e -> Integer.valueOf(e)
        System.out.println(max);
        System.out.println(max1);
        // hai cú pháp dòng 97,98 đều có mục đích như nhau, method reference sinh ra là để thay thế cho lamda expression
        // nếu không quen các triền khai method reference thì dùng lamda expression là lựa chọn tốt, cũng không quá dài.

    }
    public static void SummaryStatistics(){
        Integer[] a = {7,6,4,8,4,3,3,6};
        IntSummaryStatistics stats = Arrays.stream(a).mapToInt(x -> x).summaryStatistics();
        System.out.println(stats.getMax() + " " + stats.getMin() + " " + stats.getAverage() + " " + stats.getCount() + " " + stats.getSum());
    }
    public static void ComparatorAndPredicate(){
        // Comparator
        List<Integer> list = List.of(5,3,7,9,4,2,6,7);
        Comparator<Integer> comparator = (x,y) -> y-x;
        /*
        * sort sẽ lặp qua tất cả các cặp của trong luồng và so sánh hai phần tử một.
        * nếu x-y > 0, java sẽ hiểu là x>y, và sẽ đổi chỗ hai phần tử.
        * nếu y-x > 0, java sẽ hiểu là y>x, và đổi chỗ hai phần tử.
        * java chỉ đổi chỗ khi hai phần tử khi kết quả trả về của comparator là số nguyên dương.
         */
        list.stream().sorted(comparator).forEach(System.out::println);

        // Predicate
        List<Integer> list1 = IntStream.range(1,10).boxed().collect(Collectors.toList());
        /*
        The method boxed() is designed only for streams of some primitive types (IntStream, DoubleStream, and LongStream)
         to box each primitive value of the stream into the corresponding wrapper class (Integer, Double, and Long respectively).
        */
        Predicate<Integer> predicate = (x) -> x % 2 == 0;
        /*
        * predicate sẽ trả về true hoặc false
        * trong stream bên dưới, lặp qua từng phần tử, nếu predicate trả về false, phần tử đó sẽ bị loại ra khỏi stream.
         */
        list1.stream().filter(predicate).forEach(System.out::println);
    }

}