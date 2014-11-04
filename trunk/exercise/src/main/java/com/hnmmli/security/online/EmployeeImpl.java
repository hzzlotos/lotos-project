package com.hnmmli.security.online;

public class EmployeeImpl implements Employee
{
    private String firstName;

    private String lastName;

    // @Override
    // public int hashCode()
    // {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
    // result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
    // return result;
    // }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        EmployeeImpl other = (EmployeeImpl) obj;
        if (this.firstName == null)
        {
            if (other.firstName != null)
            {
                return false;
            }
        }
        else
            if (!this.firstName.equals(other.firstName))
            {
                return false;
            }
        if (this.lastName == null)
        {
            if (other.lastName != null)
            {
                return false;
            }
        }
        else
            if (!this.lastName.equals(other.lastName))
            {
                return false;
            }
        return true;
    }

    @Override
    public String getFirstName()
    {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String getLastName()
    {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public String getFullName()
    {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void printFullName()
    {
        System.out.println(this.getFullName());
    }
}