public class Planet{
	double xxPos;  // its current position
	double yyPos;
	double xxVel;
	double yyVel;
	double mass; 
	String imgFileName;
	double G = 6.67E-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double r; 
		r = Math.sqrt(Math.pow(p.xxPos - xxPos, 2) + Math.pow(p.yyPos - yyPos, 2));
		return r;
	}

	public double calcForceExertedBy(Planet p){
	    double F = mass * p.mass * G / Math.pow(calcDistance(p), 2);
	    return F;
	}

	public double calcForceExertedByX(Planet p){
        double Fx = calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
        return Fx;
		}

	public double calcForceExertedByY(Planet p){
        double Fy = calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
        return Fy;
    }
	public double calcNetForceExertedByX(Planet[] p){
        double Fxnet = 0;
        for(Planet e:p){
	        if (e.equals(this)){
	        	continue;
	        }
	        else{
	        	Fxnet += calcForceExertedByX(e);
	        }
		}  
	        return Fxnet;
	}
    public double calcNetForceExertedByY(Planet[] p){
        double Fynet = 0;
        for(Planet e:p){
	        if (e.equals(this)){
	        	continue;
	        }
	        else{
	        	Fynet += calcForceExertedByY(e);
	        }
	    }
	        return Fynet;
	}
	public void update(double dt, double fX, double fY){
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel = xxVel + aX * dt;
		yyVel = yyVel + aY * dt;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}
}   