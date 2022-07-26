class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
       	Queue<Integer> line=new LinkedList<Integer>();
	Stack<Integer> menu=new Stack<Integer>();

	for(int i: students)//pushing the students into the queue according to the probleem statement
        {
	     line.offer(i);
	}

	for(int i=sandwiches.length-1;i>=0;i--)//pushing in reverse order it order to acess the top at first 
        {
	    menu.push(sandwiches[i]);
	}

	int counter=line.size()*menu.size();//maximum possible iteration possible 
	while(counter-->0)
        {
		if((!menu.isEmpty())&&line.peek()==menu.peek())//if the student has got the sandwitch he wants 
                {
		    line.poll();
		    menu.pop();
		}
		else//if the student has not got the sandwitch he wants 
                {
                   if(line.size()>0)//waiting for the desired sandwich in the line 
                   {
		      line.offer(line.remove());//removing from the front of the queue and adding at the rear of the queue 
                   }
                   else
                      return 0;//if line size is zero means every student has got the sandwitch, no one is left to consume sandwitch so returning zero 
		}
        }
	return line.size();
    }
}