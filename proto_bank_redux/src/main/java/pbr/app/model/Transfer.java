package pbr.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table
@Indexed
@SequenceGenerator(name = "tranf_seq", initialValue = 1, allocationSize = 1)
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tranf_seq")
	private int tid;
	private int sid;
	private int rid;
	private double amount;
	private String status;
}
