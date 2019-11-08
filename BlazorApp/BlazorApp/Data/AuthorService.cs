using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BlazorApp.Data
{
    public class AuthorService : IAuthorService
    {   
        public List<Author> Authors { get; set; }

        public AuthorService()
        {
            Authors = new List<Author>();

            Authors.Add(new Author("172-32-1176", "Johnson", "White", "johnson.white@gmail.com", 11000, "4084967223", "Menlo Park"));
            Authors.Add(new Author("213-46-8915", "Marjorie", "Green", "marjorie.green@gmail.com", 22000, "4159867020", "Oakland"));
            Authors.Add(new Author("238-95-7766", "Cheryl", "Carson", "cheryl.carson@gmail.com", 39000, "4155487723", "Berkeley"));
            Authors.Add(new Author("267-41-2394", "Michael", "O'Leary", "michael.oleary@gmail.com", 31000, "4082862428", "San Jose"));
            Authors.Add(new Author("274-80-9391", "Dean", "Straight", "dean.straight@gmail.com", 29000, "4158342919", "Oakland"));
        }

        public List<Author> GetAuthors()
        {
            return Authors;
        }

        public Author GetAuthorById(string authorId)
        {
            return Authors.Where(auth => auth.AuthorId == authorId).FirstOrDefault();
        }

        public bool SaveAuthor(Author author)
        {
            author.AuthorId = GetNewAuthor();
            Authors.Add(author);
            return true;
        }

        private string GetNewAuthor()
        {
            string id;
            Random random = new Random();
            id = random.Next(100, 1000).ToString() + "-";
            id += random.Next(10, 100).ToString() + "-";
            id += random.Next(1000, 10000).ToString();

            return id;
        }

        public void DeleteAuthor(string authorId)
        {
            throw new NotImplementedException();
        }
    }
}
