
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Servlet implementation class SyncServlet
 */
@WebServlet("/SyncServlet")
public class SyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SyncServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long t1 = System.currentTimeMillis();

		doSomeThing(request, response);

		System.out.println("sync use:" + (System.currentTimeMillis() - t1));
	}

	private void doSomeThing(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		try {
			//模拟耗时操作
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		}

		//
		response.getWriter().append("done");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
