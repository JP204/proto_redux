package pbr.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transfer_id")
	private String trid;
	
	@Column(name = "sender_id")
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private String sender;
	
	@Column(name = "receiver_id")
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private String receiver;
	
	@Column(name = "transfer_amount")
	private double amount;
	
	@Column(name = "date_made")
	private Date timestamp;
	
}
