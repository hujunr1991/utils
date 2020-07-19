package com.example.springboorutil.jianzhiOffer.two;

import java.util.Arrays;



public class Sort {

    /**
     *
     * https://blog.csdn.net/jackesy/article/details/80135033?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
     * 直接插入排序:根据其原理，我们把该无序数列看成两个部分
     * 具体流程如下：
     *
     * 1、首先比较数组的前两个数据，并排序；
     *
     * 2、比较第三个元素与前两个排好序的数据，并将第三个元素放入适当的位置；
     *
     * 3、比较第四个元素与前三个排好序的数据，并将第四个元素放入适当的位置；
     *
     * ......
     *
     * 4、直至把最后一个元素放入适当的位置。
     */


    /**

     * 直接插入排序

     * 时间复杂度：O（n^2）

     *@param data

     */

    public static void insertSort(int[] data){

        int temp;
        for (int i =1; i< data.length; i++) {

            /*
             * 第一个for循环
             * 把数组分成两部分，右边为未排序，左边为已排序
             * 记录排序与未排序分割点temp（temp为下一个排序对象）
             */

            temp = data[i];
            int j;
            for (j = i-1; j>=0; j--) {
                /*
                 * 第二个for循环
                 * 将排序对象temp与已排序数组比较
                 * 当temp比最近左边的数大时（按从小到大循序排列时）
                 * 直接结束本次循环，进行下一个数排序
                 * 否则比左边这个数小时将这个数后移，腾出这个数的位置
                 */
                if (data[j] > temp) {
                    data[j+1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1]= temp;
        }

        System.out.println("插入排序为:" + Arrays.toString(data));
    }


    /*
       也是利用插入排序，平均分成很多分进行比较
       在一定程度上希尔排序就是在直接插入排序的基础上加上一个步长。
     */
    private static void shellSort(int[] array) {
        int temp = 0;
        int j = 0;
        for (int increment = array.length/2; increment > 0; increment = increment/2) {
            for (int i = increment; i< array.length; i++) {
                temp = array[i];

                for (j = i-increment; j >=0; j = j-increment) {
                    if (array[j] > temp) {
                        array[j+increment] = array[j];
                    } else {
                        break;

                    }
                }
            }
            array[j+increment] = temp;
        }

        System.out.println("希尔排序为:" + Arrays.toString(array));

    }


    /*
    一轮一轮遍历，找出最小的记录以最前面的交换
    它只需要一个附加单元用于数据交换
     */
    private static void selectSort(int[] array) {

//        for (int i = 0; i< array.length; i++) {
//            //开头设置最小值和下标
//            int flag = i;
//            int temp = array[i];
//
//            for (int j = i+1; j< array.length; j++) {
//                //如果后面的值比前面的大，更新之前认为最小的值
//                if (temp > array[j]) {
//                    temp = array[j];
//                    flag = j;
//                }
//            }
//
//            //一圈遍历完成找到最小的，进行交换
//            if (flag != i) {
//                //最小的与第一个进行更换
//                array[i] = temp;
//                array[flag]= array[i];
//            }
//        }

        int min;

        for (int i = 0; i<array.length; i++) {
            min = i;
            for (int j = i+1; j<array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            //交换元素
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        System.out.println("简单选择排序为:" + Arrays.toString(array));
    }

    //每进行一次会把最大的元素放在最后面。所以最后面的有序，不用再比较了
    /*
    {9,6,11,3, 12 ,13}==========i = 3时完成了，此次会直接break
     */

    private static void bubbleSort(int[] array) {

        int i;
        int temp;
        boolean flag;
        for (i = 0; i <array.length-1; i++) {
            flag = true;
            for (int j =0; j <array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        System.out.println("冒泡排序为：" + Arrays.toString(array));
    }


    private static void myQuickSort(int[] array, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp是基准点
        temp = array[low];
        while (i< j) {
            //先看右边，依次往左递减
            while (temp <= array[j] && i< j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= array[i] && i<j) {
                i++;
            }
            //如果满足条件就交换
            if (i < j) {
                t= array[j];
                array[j] = array[i];
                array[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        array[low] = array[i];
        array[i] = temp;
        myQuickSort(array, low , j-1);
        myQuickSort(array, j+1, high);
        System.out.println("快速排序为:" + Arrays.toString(array));
    }

    public static void main(String[] args) {
//        int[] array = {5,4,1,2,8,6,7,3,10,9};
//        insertSort(array);
//        shellSort(array);
//        selectSort(array);
        int[] array = {9,6,11,3, 12 ,13};
//        bubbleSort(array);
        myQuickSort(array, 0, array.length - 1);
        heapSort(array);
    }

    private static void heapSort(int[] array) {

        //1.构建大顶堆
        for (int i = array.length/2 -1; i >=0; i++) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(array,i,array.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=array.length-1;j>0;j--){
            swap(array,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(array,0,j);//重新对堆进行调整
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k=i*2+1;k<length;k=k*2+1){
            //如果左子结点小于右子结点，k指向右子结点
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

/*
总结：
  直接插入排序：将数据分为有序和无序两个部分，刚开始左边就一个，后面插入的依次和左边无序的比较，按照大小放在合适的位置，o(n^2)
  https://baijiahao.baidu.com/s?id=1644158198885715432&wfr=spider&for=pc
  希尔排序:是对插入排序的升级，相当于给差额u排序加了一个步长，按照步长进行递减分组粗调的方式减少了直接排序的工作量，o(n^(1.3-2))
  选择排序：每次遍历一次，找出最小的元素，然后和第一个交换，以此类推，o(n^2)
  堆排序：就是构建一个最大数的二叉树，不断需要维护这个二叉树，O(nlogn)
  冒泡排序：从最开始的位置开始，每次比较相邻的两个元素，相当于每次把最大数找到放在最后的位置上，o(n^2)
  快排：采用分治法，选一个基准点，从头和尾依次和这个元素进行比较，记录从头开始比基准值大，从尾开始比基准值小的值，进行交换，之后将得到的两个数按照同样的方式操作，直到被分为1，O(nlogn)
  归并排序：将要排序的数据按照两两进行有序后合并，好比8个数，分成4个两两的数，有序后合并成2个4个元素的数组，在这里面排序，最后合并的就是有序的数了
 */


}
