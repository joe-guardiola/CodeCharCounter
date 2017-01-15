
public class QuoteState extends CommentParserState
{
	private static QuoteState instance = null;
	public QuoteState()
	{
		
	}
	
	public static QuoteState getInstance()
	{
		if(instance == null)
		{
			instance = new QuoteState();
		}
		
		return instance;
	}
	
	@Override
	public void star(CommentParser c)
	{
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void slash(CommentParser c)
	{
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void quote(CommentParser c)
	{
		c.changeState(CodeState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.changeState(BackslashState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void endline(CommentParser c)
	{
		c.changeState(CodeState.getInstance());
	}
	@Override
	public void character(CommentParser c)
	{
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
}
