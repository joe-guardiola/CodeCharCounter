
public class JavaDocState extends CommentParserState
{
	private static JavaDocState instance = null;
	public JavaDocState()
	{
		
	}
	
	public static JavaDocState getInstance()
	{
		if(instance == null)
		{
			instance = new JavaDocState();
		}
		
		return instance;
	}
	
	@Override
	public void star(CommentParser c)
	{
		c.changeState(JavaDocEndStarState.getInstance());
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
	@Override
	public void slash(CommentParser c)
	{
		c.setJavadocCounter(c.getJavadocCounter() +  1);
	}
	@Override
	public void quote(CommentParser c)
	{
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
	@Override
	public void endline(CommentParser c)
	{
		
	}
	@Override
	public void character(CommentParser c)
	{
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
}
