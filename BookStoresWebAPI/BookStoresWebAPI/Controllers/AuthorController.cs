using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BookStoresWebAPI.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace BookStoresWebAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class AuthorController : ControllerBase
    {
        
        [HttpGet]
        public IEnumerable<Author> Get()
        {
            using (var context = new BookStoresDBContext())
            {
                //get all authors
                //return context.Author.ToList();

                //add a author
                //Author author = new Author();
                //author.FirstName = "John";
                //author.LastName = "Smith";

                //context.Author.Add(author);

                //update 
                //Author author = context.Author.Where(auth => auth.FirstName == "John").FirstOrDefault();
                //author.Phone = "777-777-7777";

                //remove author
                Author author = context.Author.Where(auth => auth.FirstName == "John").FirstOrDefault();
                context.Author.Remove(author);

                context.SaveChanges();

                //get author by id
                return context.Author.Where(auth => auth.FirstName == "John").ToList();
            }
        }
    }
}
