using CuriousDriveWebAPI.CuriousDrive.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class QuestionRepository : Repository<Question>, IQuestionRepository
    {
        public QuestionRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }

        public List<Question> GetRecentQuestions()
        {
            return CuriousDriveContext.Question.OrderByDescending(question => question.CreatedDate).ToList();
        }

        public Question GetQuestionDetails(int questionId)
        {
            return CuriousDriveContext.Question.Include(question => question.Comment)
                                                    .ThenInclude(comment => comment.User)
                                                .Include(question => question.PostVote)
                                                .Include(question => question.User)
                                                .Include(question => question.QuestionAnswer)
                                                    .ThenInclude(questionAnswer => questionAnswer.User)
                                                    .ThenInclude(questionAnswer => questionAnswer.Comment)
                                                        .ThenInclude(questionAnswerComment => questionAnswerComment.User)
                                                .Include(question => question.QuestionClass)
                                                    .ThenInclude(@class => @class.Class)
                                                .Include(question => question.Tag)
                                                    .ThenInclude(tag => tag.TagDetail)
                                                        .ThenInclude(tagDetail => tagDetail.TaggedUser)
                                                .Where(question => question.QuestionId == questionId).ToList().FirstOrDefault();
        }
    }
}