package view_prjt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import view.MyUtil;

/*
 * Table Model
 */
public class TModel extends JFrame {

	List<Eng> list = new ArrayList<>();
	{
		list.add(new Eng("apple", "사과", "사과는 맛있어"));
		list.add(new Eng("orange", "오렌지", "오렌지는 달아"));
		list.add(new Eng("knife", "칼", "오렌지는 달아"));
		list.add(new Eng("book", "책", "오렌지는 달아"));
		list.add(new Eng("glass", "유리", "오렌지는 달아"));
		list.add(new Eng("window", "창문", "오렌지는 달아"));
		list.add(new Eng("light", "빛", "오렌지는 달아"));
		list.add(new Eng("perfume", "향수", "오렌지는 달아"));
		list.add(new Eng("mouth", "입", "오렌지는 달아"));
		list.add(new Eng("lip	", "입술", "오렌지는 달아"));
		list.add(new Eng("king", "왕", "오렌지는 달아"));
		list.add(new Eng("queen", "여왕", "오렌지는 달아"));
		list.add(new Eng("slave", "노예", "오렌지는 달아"));
		list.add(new Eng("devil", "악마", "오렌지는 달아"));
		list.add(new Eng("angel", "천사", "오렌지는 달아"));
	}

	public TModel(int w, int h, String title) {
		MyUtil.init(this, w, h, title);

		// 컬럼정보
		Object[] columnNames = { "단어", "뜻", "예문" };

		// 행 내용 입력
		Object[][] rowData = new Object[list.size()][columnNames.length];
		for (int i = 0; i < list.size(); i++) {
			Eng vc = list.get(i);
			rowData[i][0] = vc.getWord();
			rowData[i][1] = vc.getMeaning();
			rowData[i][2] = vc.getSentence();
		}

		JTable table = new JTable(rowData, columnNames);

		table.setAutoCreateRowSorter(true);
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		JScrollPane scrollPane = new JScrollPane(table);

		TableModel model = table.getModel();
		model.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				int row = e.getFirstRow();
				int col = e.getColumn();

				Object data = model.getValueAt(row, col);
				System.out.println(data);
			}
		});

		// 하단 저장 버튼
		JButton btn = new JButton("저장");
		// 버튼은 actionlistener!
		btn.addActionListener(new ActionListener() {
			// 데이터를 다 읽어와야하고
			// 실제 데이터가 저장되어있는 모델에 접근해야 함
			@Override
			public void actionPerformed(ActionEvent e) {
				// 행과 열의 길이
				int rowLen = model.getRowCount();
				int colLen = model.getColumnCount();

				// 행, 열의 정보를 알아냈으면, 중첩반복문을 이용해서
				List<Eng> newList = new ArrayList<Eng>();
				for (int i = 0; i < rowLen; i++) {
					Eng newVc = newList.get(i);
					for (int j = 0; j < colLen; j++) {
						Object data = model.getValueAt(i, j);
						System.out.println(data);
						switch (j) {
						case 0:
							newVc.setWord((String) data);
							break;
						case 1:
							newVc.setWord((String) data);
							break;
						case 2:
							newVc.setWord((String) data);
							;
							break;
						}

					}
					newList.add(newVc);
				}

				for (Eng newMember : newList) {
					System.out.println(newMember);
				}
			}
		});
		add(scrollPane);
		add(btn, BorderLayout.SOUTH);
		pack();
	}

	public static void main(String[] args) {
		new TModel(800, 300, "Word List").setVisible(true);
	}

}
