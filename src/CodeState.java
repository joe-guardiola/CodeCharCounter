
public class CodeState extends CommentParserState
{
	private static CodeState instance = null;
	public CodeState()
	{
		
	}
	
	public static CodeState getInstance()
	{
		if(instance == null)
		{
			instance = new CodeState();
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
		c.changeState(SlashState.getInstance());
	}
	@Override
	public void quote(CommentParser c)
	{
		c.changeState(QuoteState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void endline(CommentParser c)
	{
		
	}
	@Override
	public void character(CommentParser c)
	{
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
}
