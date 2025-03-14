import './global.css'
import Navbar from './_navbar/navbar';

const RootLayout = ({
  children,
}: {
  children: React.ReactNode
}) => {
  return (
    <>
      <header>
        <Navbar />
      </header>
      {children}
    </>  
  )
}

export default RootLayout;
