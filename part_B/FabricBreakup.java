import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FabricBreakup {
	public static void main(String args[]) throws FileNotFoundException, EmptyStackException {

		//Created 2 stacks, one for storing the values and other for maxValues till that point
		StackInterface stack = new Stack();
		StackInterface max = new Stack();

		File file = new File(args[0]);
		Scanner s = new Scanner(file);

		String N = s.nextLine();
		int maxValue = 0;

		while(s.hasNext()){

			// Storing the instrucrions of the input as an array of strings
			String[] operation = s.nextLine().split(" ");

			if(operation[1].equals("1")){ //O(n)
				int value = Integer.parseInt(operation[2]);

				if(value>maxValue)
					maxValue=value;

				stack.push(value);
				max.push(maxValue);
			}

			else{
				if(stack.isEmpty()) //O(1)
					System.out.println(operation[0]+" -1");
				else{ //O(n^2)
					int topple=0;

					// Comparing the top elements of both stacks till they are same
					// i.e till we find the maximum value shirt in the pile
					while((int)stack.top() != (int)max.top()){
						stack.pop();
						max.pop();
						topple++;
					}
					stack.pop();
					max.pop();

					System.out.println(operation[0]+ " " +topple);

					// Resetting maxValue to current highest value of shirt in the new pile
					if(max.isEmpty())
						maxValue=0;
					else
						maxValue=(int)max.top();
				}
			}
		}
	}
}
