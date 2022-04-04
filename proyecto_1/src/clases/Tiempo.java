package clases;

public class Tiempo {
	    private long begin, end;
	 
	    public void start(){
	        begin = System.currentTimeMillis();
	    }
	 
	    public void stop(){
	        end = System.currentTimeMillis();
	    }
	 
	    public long getTime() {
	        return end-begin;
	    } 
	    public double getSeconds(long miliseg) {
	        return (miliseg) / 1000.0;
	    }
	 
	    public double getMinutes(double miliseg) {
	        return (miliseg) / 60000.0;
	    }
	 
	    public double getHours(long miliseg) {
	        return (miliseg) / 3600000.0;
	    }
	 
	}

