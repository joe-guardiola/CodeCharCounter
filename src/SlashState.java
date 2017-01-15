
public class SlashState extends CommentParserState
{
	private static SlashState instance = null;
	public SlashState()
	{
		
	}
	
	public static SlashState getInstance()
	{
		if(instance == null)
		{
			instance = new SlashState();
		}
		
		return instance;
	}
	
	@Override
	public void star(CommentParser c)
	{
		c.changeState(StarState.getInstance());
	}
	@Override
	public void slash(CommentParser c)
	{
		c.changeState(SingleLineCommentState.getInstance());
		c.setCommentCounter(c.getCommentCounter() + 2);
	}
	@Override
	public void quote(CommentParser c)
	{
		c.changeState(QuoteState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 2);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.changeState(CodeState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 2);
	}
	@Override
	public void endline(CommentParser c)
	{
		c.changeState(CodeState.getInstance());
	}
	@Override
	public void character(CommentParser c)
	{
		c.changeState(CodeState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 2);
	}
}
