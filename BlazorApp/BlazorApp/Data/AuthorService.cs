using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BlazorApp.Data
{
    public class AuthorService : IAuthorService
    {
        public DateTime CreationDate { get; set; }
        public List<Author> Authors { get; set; }

        public AuthorService()
        {
            CreationDate = DateTime.Now;            

            Authors = new List<Author>();

            Authors.Add(new Author("172-32-1176", "Johnson", "White", "408 496 7223", "Menlo Park"));
            Authors.Add(new Author("213-46-8915", "Marjorie", "Green", "415 986 7020", "Oakland"));
            Authors.Add(new Author("238-95-7766", "Cheryl", "Carson", "415 548 7723", "Berkeley"));
            Authors.Add(new Author("267-41-2394", "Michael", "O'Leary", "408 286 2428", "San Jose"));
            Authors.Add(new Author("274-80-9391", "Dean", "Straight", "415 834 2919", "Oakland"));
        }

        public List<Author> GetAuthors()
        {
            return Authors;
        }

        public Author GetAuthorById(string authorId)
        {
            return Authors.Where(auth => auth.AuthorId == authorId).FirstOrDefault();
        }

        public DateTime GetCreatedDate()
        {
            return CreationDate;
        }

        public string GetVersion()
        {
            return "v1";
        }
    }
}
