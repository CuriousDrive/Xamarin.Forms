using CuriousDriveWebAPI.CuriousDrive.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class QuestionClassRepository : Repository<QuestionClass>, IQuestionClassRepository
    {
        public QuestionClassRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }

        public List<QuestionClass> GetQuestionClassesByQuestionId(int questionId)
        {
            return CuriousDriveContext.QuestionClass.Include(@class => @class.Class)
                                                .Where(questionClass => questionClass.QuestionId == questionId).ToList();
        }
    }
}