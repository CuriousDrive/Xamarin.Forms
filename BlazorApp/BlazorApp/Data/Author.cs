using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace BlazorApp.Data
{
    public class Author
    {
        public string AuthorId { get; set; }
        [Required (ErrorMessage = "First name is required")]
        public string FirstName { get; set; }
        [Required(ErrorMessage = "Last name is required")]
        public string LastName { get; set; }
        [StringLength (20, ErrorMessage ="City name can not be longer than 20 chars")]
        public string City { get; set; }
        [DataType(DataType.EmailAddress)]
        [EmailAddress(ErrorMessage = "Please enter valid email address")]
        public string EmailAddress { get; set; }
        [Range(1000,99999999, ErrorMessage = "Salary should be greater than $1000")]
        public int Salary { get; set; }

        public string PhoneNumber { get; set; }

        public Author()
        {

        }
        public Author(string authorId, string firstName, string lastName, string emailAddress, int salary,
                    string phoneNumber, string city)
        {
            AuthorId = authorId;
            FirstName = firstName;
            LastName = lastName;
            Salary = salary;
            EmailAddress = emailAddress;
            PhoneNumber = phoneNumber;
            City = city;
        }
    }
}
