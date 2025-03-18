class Lower_Upper_Bound{
    public static int lowerbound(int[] arr, int target){
        int ll = 0, ul = arr.length-1;
        int mid;
        while(ll<=ul){
            mid = (ll+ul) / 2;
            if(arr[mid]<target){
                ll = mid+1;
            }
            else{
                ul = mid-1;
            }
        }
        return ll;
    }
    public static int upperbound(int [] arr, int target){
        int ll = 0, ul = arr.length-1;
        int mid;
        while(ll<=ul){
            mid = (ll+ul) / 2;
            if(arr[mid]<=target){
                ll = mid+1;
            }
            else{
                ul = mid-1;
            }
        }
        return ll;
    }

    public static int floor(int[] arr, int target){
        int ll=0,ul=arr.length-1, mid;
        int floor = -1;
        while(ll<=ul){
            mid = (ul-ll)/2 + ll;
            if(arr[mid]==target){
                return arr[mid];
            }
            else if(arr[mid]>target){
                ul = mid-1;
            }
            else{   
                ll = mid+1;
                floor = arr[mid];
            }
        }

        return floor;
    }


    public static void main(String[] args) {
        int [] arr = {};
        // System.out.println(lowerbound(arr,2));
        // System.out.println(upperbound(arr,5));
        System.out.println(lowerbound(arr,0));
        System.out.println(upperbound(arr,0));
        // System.out.println(floor(arr, 0));
        // System.out.println(floor(arr, 3));
        // System.out.println(floor(arr, 4));
    }
}