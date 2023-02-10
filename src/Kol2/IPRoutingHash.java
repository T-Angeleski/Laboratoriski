package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class IPRoutingHash {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, String> interfacesByRouter = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String router = br.readLine();
			String[] interfaces = br.readLine().split(",");

			String filtered = "";
			for (String anInterface : interfaces) {
				int end = anInterface.lastIndexOf(".");
				filtered += (anInterface.substring(0, end)) + " ";
			}
			interfacesByRouter.put(router, filtered);
		}

		//Baranje
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String router = br.readLine();
			String network = br.readLine();
			//Delete last .
			int toSplit = network.lastIndexOf(".");
			network = network.substring(0, toSplit);

			if (!interfacesByRouter.containsKey(router)) {
				System.out.println("ne postoi");
				continue;
			}

			String[] routerNetworks = interfacesByRouter.get(router).trim().split(" ");
			boolean flag = false;
			for (String routerNetwork : routerNetworks) {
				if (network.equals(routerNetwork)) {
					flag = true;
					break;
				}
			}

			System.out.println(flag ? "postoi" : "ne postoi");
		}

	}
}
