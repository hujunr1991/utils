package com.example.springboorutil.jianzhiOffer.two;

public class Problem8_83 {

    /*
    1、 用两个指针分别指向数组的第一个元素和最后一个元素，按照题目的规则，第一个元素应该是大于或者等于最后一个元素的。
    2、找到第一个指针和第二个指针中间的元素
    3、如果该中间元素位于前面的递增数组，则它应该大于或者等于第一个指针指向的元素。此时数组中最小的元素应该位于该中间元素的后面，因此我们把第一个指针指向该中间元素，这样可以缩小查找范围。移动之后第一个指针任然位于前面的递增子数组。
    4、如果该中间元素小于或者等于第二个指针指向的元素，说明中间元素位后面的递增子数组，此时数组中最小的元素应该位于该中间元素的前面，因此我们将第二个指针指向该中间元素，可以缩小查找范围。移动之后第二个指针任然位于后面的递增子数组。
    5、用更新后的两个指针重复做上面的操作，直到最后，第一个指针总会指向前面递增子数组中的最后一个元素，第二个指针总会指向后面递增子数组中的第一个元素，此时，第一个指针指向的元素和第二个指针指向的元素相邻，而第二个指针指向的元素刚好是该数组中最小的元素。
————————————————
版权声明：本文为CSDN博主「sword  man」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_37447414/article/details/85054650

     */

    public static void main(String[] args) {

        int[] array = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));

    }

    private static int minNumberInRotateArray(int[] array) {

        int index1=0;//指向数组第0个元素
        int index2=array.length-1;//指向数组最后一个元素
        int indexMid=index1;//用来处理第一种特殊情况
        while(array[index1]>=array[index2]) {
            if(index2-index1==1)//查找结束条件
            {
                indexMid=index2;
                break;
            }

            indexMid=(index1+index2)/2;//找到中间元素的下标
            //用来处理第二种特殊情况
            if(array[index1]==array[index2]&&array[index2]==array[indexMid]) {
                return minInOrder(array,index1,index2);
            }

            //当中间元素大于等于第一个指针指向的元素，
            if(array[indexMid]>=array[index1])
            {
                index1=indexMid;
            }
            //当中间元素小于等于第二个指针指向的元素
            else if(array[indexMid]<=array[index2])
            {
                index2=indexMid;
            }
        }

        return indexMid;
    }

    //第二种特殊情况的处理，就是采用顺序查找，通过遍历数组来查找最小值
    private static int minInOrder(int[] array, int index1, int index2) {

        int result=array[index1];
        for(int i=index1;i<=index2;i++)
        {
            if(result>array[i])
            {
                result=array[i];
            }
        }
        return result;

    }
}
