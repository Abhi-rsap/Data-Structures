package net.codejava.swing;

class node
{   node next;
    float coeff;
    int degree;
public node()
{
   coeff=0;
   degree=0;
   next=null;
}
node(float c,int d)
{
   coeff=c;
   degree=d;
   next=null;
}
}
public class polysolver {
node head=null;
int size=0;
node tail=null;
float x1,x2,x3=0;
public polysolver()
{	head=null;}
void insert(float i, int d)
{
	if(head==null)
	{
		head=new node(i,d);
	}
	else
	{   node t=head;
	    while(t.next!=null)
	    {
	    	t=t.next;
	    }
		 node temp = new  node(i,d);
	t.next=temp;
		}
}


void print()

{
	node s=head;
	while(s!=null)
	{
	
		System.out.println(s.coeff);
		s=s.next;
	}
	
}

String display()
{  node c=head;
	String s="";
	while(c!=null)
	{
		s=s+Float.toString(c.coeff)+"  x^"+Integer.toString(c.degree);
		c=c.next;
		if(c!=null)
		{
			s=s+" + ";
		}
	}
	
	return s;
}
polysolver add(polysolver a)
{  polysolver k = new polysolver();
   node k1=k.head;
   node t1=this.head;
   node t2=a.head;
   while(t1!=null && t2!=null) {
	   if(t1.degree==t2.degree)
	   {   
		   k.insert((t1.coeff+t2.coeff),t1.degree);
		   t1=t1.next;
		   t2=t2.next;
		   }
	   else
	   
		   if(t1.degree < t2.degree)
		   {  System.out.println("LEss than");
			   k.insert(t2.coeff,t2.degree);
			   t2=t2.next;
		   }
		   else
		   
			   if(t1.degree > t2.degree)
			   { 
				   k.insert(t1.coeff, t1.degree);
			   t1=t1.next;
			   }
		
	
   }
   return k;   	
}
polysolver sub(polysolver a)
{  polysolver k = new polysolver();
   node k1=k.head;
   node t1=head;
   node t2=a.head;
   while(t1!=null && t2!=null) {
	   if(t1.degree==t2.degree)
	   {
		   k.insert((t1.coeff-t2.coeff),t1.degree);
		   t1=t1.next;
		   t2=t2.next;   }
	   else
	   {
		   if(t1.degree < t2.degree)
		   {
			  k.insert(t2.coeff,t2.degree);
			   t2=t2.next;
		   }
		   else
		   {
			   if(t1.degree > t2.degree)
			   {   
			   k.insert(t1.coeff, t1.degree);
			   t1=t1.next;
			   }
		   }
	   }
	
   }
   return k;   	
}
polysolver mult(polysolver a)
{  polysolver k = new polysolver();
   node k1=head;
   node t1=head;	
   node t2=a.head;
   while(t1!=null) {
	   while(t2!=null)
	   {
		   k.insert(t1.coeff*t2.coeff, t1.degree+t2.degree);
		   t2=t2.next;
	   }
	   t2=k1;
	t1=t1.next;   }
   return k;
   }
	  
float solveP1(float b,float c)
{
	return((-c)/b);	
}
void solveP2(float a,float b,float c)
{
   System.out.println(a+""+b+""+c);
	double D=(b*b)-(4*a*c);
	if(D<0)
	{
		x1=x2=-1;
	}
	else
	{  System.out.println(Math.sqrt(D));
		x1=(float)(((-b+(Math.sqrt(D)))/(2*a)));
		x2=(float) (((-b-(Math.sqrt(D)))/(2*a)));
	}
}

float getP2x1()
{
    return x1;
}

float getP2x2()
{
    return x2;
}



}
