package demo_lomdok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class employee {

	
	private int id;
	private String name;
	private String natives;
	
}
