package org.example;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionsClass {
    public static void main(String[] args) {
//        initializeByStream();
//        AddAll();
//          EmptyCollection();
//        MinMaxSearchSortReverse_ReverseOrder_withComparator();
//        Frequency();
//        CoPy();
//        Swap();
//        Shuffle();
        Rotate();
    }
    public static void initializeByStream(){
        List<Integer> numsInt = Stream.iterate(1, i -> i+1).limit(10).collect(Collectors.toList());
        List<Double> numsDou = Stream.iterate(1.0, i -> i+1).limit(10).collect(Collectors.toList());
        System.out.println(numsInt);
        System.out.println(numsDou);
    }
    public static void EmptyCollection(){
        List<Integer> nums = Collections.emptyList();
//        nums.add(2); // can't add because it is immutable.
        nums = new ArrayList<>();
        nums.add(1); // true because initialize new List.
        nums.forEach(System.out::println);
        /* Set and Map is the same */
    }
    public static void AddAll(){
        // add all specific elements into specific collection.
        List<String> names = new ArrayList<>();
        names.add("thien");
        Collections.addAll(names, "thinh", "luong");
        names.forEach(System.out::println);
        /*
        note: if initialize by List.of(), we cannot add into list because it is immutable.
        * Set and Map Structure is the same.
        */
    }
    public static void MinMaxSearchSortReverse_ReverseOrder_withComparator(){
        List<Integer> nums = new ArrayList<>();
        IntStream.range(1,10).forEach(x -> nums.add(x));

        // Min, Max without Comparator
        System.out.println(Collections.min(nums));
        System.out.println(Collections.max(nums));
        // Min, Max with Comparator implement by Lamda Expression.
        // By default, always call default comparator, implementation below will reverse the result.
        System.out.println("min: " + Collections.min(nums, (x,y) -> y-x));
        System.out.println("max: " + Collections.max(nums, (x,y) -> y-x));

        /* Sort */
        // note: with Collections work on source object, that means will change source object
        // so be careful when using or using stream insteadof.
        // by default without Comparator, collection will be sorted in ascending.
        System.out.println("before: " + nums);
        Collections.sort(nums, (x,y) -> y-x); // this will use Comparator instead of Comparable
        System.out.println("after: " + nums);
        Collections.sort(nums); // this will call Comparable of Integer type

        /* Reverse */
        Collections.reverse(nums);
        System.out.println("reverse without order: " + nums);
        Comparator<Integer> com = Collections.reverseOrder(); // return reverse comparator for any collection
        nums.stream().sorted(com).forEach(System.out::println);

        // note: when apply for not java's object, when using default, we have to reimplement Comparator anf Predicate.
    }
    public static void Frequency() {
        // count times of appear in Collection by specific element.
        Predicate<Integer> predicate = (i) -> i % 2 != 0;
        List<Integer> nums = Stream.iterate(1, i->i+1).limit(20).filter(predicate).collect(Collectors.toList());
        System.out.println("Number of times 3 appear in nums: " + Collections.frequency(nums, 3));
    }
    public static void CoPy(){
        Predicate<Integer> predicate1 = (i) -> i % 2 != 0;
        Predicate<Integer> predicate2 = (i) -> i % 2 == 0;
        List<Integer> num1 = Stream.iterate(0, i->i+1).skip(2).limit(10)
                        .filter(predicate1)
                        .collect(Collectors.toList());
        List<Integer> num2 = Stream.iterate(0, i->i+1).skip(2).limit(10)
                .filter(predicate2)
                .collect(Collectors.toList());
        System.out.println("before: " + num1);
        System.out.println("before: " + num2);
        Collections.copy(num2,num1);
        System.out.println("num2 after copy from num1: " + num2);
    }
    public static void Swap(){
        // use to swap to specific two elements by index
        List<Integer> nums = Stream.iterate(1,i->i+1).limit(10).collect(Collectors.toList());
        System.out.println("Before Swap: " + nums);
        Collections.swap(nums, 4,5);
        System.out.println("After Swap: " + nums);
    }
    public static void Shuffle(){
        // sáo trộn ngẫu nhiên collection
        List<Integer> nums = Stream.iterate(1,i->i+1).limit(10).collect(Collectors.toList());
        System.out.println("Before Shuffle: " + nums);
        Collections.shuffle(nums);
        System.out.println("After Shuffle: " + nums);
    }
    public static void Rotate(){
        // use to rotate elements in collection
        List<Integer> nums = Stream.iterate(1,i->i+1).limit(7).collect(Collectors.toList());
        System.out.println("Before Rotate: " + nums);
        Collections.rotate(nums,4);
        System.out.println("After Rotate: " + nums);
    }
    public static void ReplaceAll(){
        // use to replace one element by a specific element in Collections.
        Set<Integer> nums = Stream.iterate(1, i -> i+1).limit(10).collect(Collectors.toSet());
        System.out.println("Before replace: " + nums);
    }
}
