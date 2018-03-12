/**Create Heap from array. A Coursera exercise*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> arr;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(arr.size());
        for (Swap swap : arr) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
      arr = new ArrayList<Swap>();
      buildHeap(data);

    }
    void buildHeap(int[] data){
    		int size = data.length;
    		for(int i =size/2; i>=0; i-- ){
    			SiftUp(i);
    		}
    }

    void SiftUp(int i){
    		int index = i;
    		int temp;
    		int l = LeftChild(i);
    		int r = RightChild(i);
    		if(l < data.length && data[l]<data[index]){
    			index = l;
    		}
    		if(r< data.length && data[r]<data[index]){
    			index = r;
    		}
    		if(i!=index){
    			arr.add( new Swap(i, index));
    			
    			temp = data[i];
    			data[i]= data[index];
    			data[index] = temp;
    			SiftUp(index);
    		}
    }
    
    int Parent(int i){
    		return (i - 1)/2;	
    }
    int LeftChild(int i){
    		return 2*i + 1;
    }
    int RightChild(int i){
    		return 2*i + 2;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
