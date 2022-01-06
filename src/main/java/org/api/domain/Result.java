package org.api.domain;

/**
 * @author mtahat
 * Use this object to wrap the response results
 * also this Object will help a lot in the unit testing
 * and the parameterize test, you can simply assert tow or more result's objects.
 */
public class Result {
	   private String capital;
	   private String largestCity;
	   private String message;
	   
	   public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setLargestCity(String largestCity) {
		this.largestCity = largestCity;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCapital() {
		   return capital;
	   }

	   public String getLargestCity() {
		   return largestCity;
	   }

	   public String getMessage() {
		   return message;
	   }

	   public Result(String capital, String largestCity, String message) {
		   this.capital = capital;
		   this.largestCity = largestCity;
		   this.message = message;
	   }
	   
	   public Result() {
		   
	   }
	   
	   public boolean isFound() {
		   return MessageHandler.isFound(this.message);
	   }
	   
	   @Override
	   public String toString() {
		   return isFound()? String.format("%nMessage: %s%n%nLargest City: %s%nCapital: %s", this.message, this.largestCity, this.capital)
		   						    : this.message;
	   }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((largestCity == null) ? 0 : largestCity.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (largestCity == null) {
			if (other.largestCity != null)
				return false;
		} else if (!largestCity.equals(other.largestCity))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
}