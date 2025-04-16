import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'

import { createBrowserRouter, RouterProvider } from 'react-router-dom'

// Páginas
import { Home } from "./routes/Home"
import { Supplier } from "./routes/Supplier"
import { Product } from './routes/Product'
import { App } from './App'

const router = createBrowserRouter([
  {
    element: <App />,
    children: [
      {
        path: "/",
        element: <Home />
      },
      {
        path: "/supplier",
        element: <Supplier />
      },
      {
        path: "/product",
        element: <Product />
      }
    ]
  }
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)
