class AlphaPanel extends JPanel {

	public BufferedImage bi;
	private float[] scales = { 1f, 1f, 1f, 1f };
	private float[] offsets = new float[4];
	private RescaleOp rop;

	public AlphaPanel(ImageIcon icon, double scale) {

		int width = (int) (scale * icon.getIconWidth());
		int height = (int) (scale * icon.getIconHeight());
		this.setPreferredSize(new Dimension(width, height));
		this.bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.bi.createGraphics().drawImage(icon.getImage(), 0, 0, width, height, null);
		rop = new RescaleOp(scales, offsets, null);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, rop, 0, 0);
	}

	public void setAlpha(float alpha) {
		this.scales[3] = alpha;
		this.rop = new RescaleOp(scales, offsets, null);
	}
}